<template>
  <div id="app">
    알람 팝업하기 => <input @click="sendAlarm" type="button" value="RequestAlarm">
    유저이름 : <input v-model="userName" type="text">
    내용 : <input v-model="message" type="text" @keyup="sendMessage">
    <hr>
    <div v-for="(item, idx) in recvList" :key="idx">
      <h3 >{{item.userName}} :: {{item.content}}</h3>
    </div>
<!--    <input type="button" value="disconnect" @click="disConnect">-->
    <div >
        <div v-for="a,idxx in typeofAlarm" :key="idxx">
            {{a}}
        </div>
    </div>
  </div>
</template>

<script>
//stompClient는 내장된 변수
import Stomp from 'webstomp-client'
import SockJS from 'sockjs-client'


export default {
  name: 'App',
  components: {
  },
  data() {
    return {
      userName : "",
      message: "",
      recvList: [],
      typeofAlarm : "",
    }
  },
  created() {
    this.connect()
  },
  methods: {
    sendMessage(e) {
      if(e.keyCode === 13 && this.userName.trim() !== '' && this.message.trim() !== '') {
        this.send()
        this.message = ''
      }
    },
    send() {
        const msg = {
          userName: this.userName,
          content: this.message
        }
        this.stompClient.send("/receive", JSON.stringify(msg), {})
    },

    sendAlarm(){
        const alram = {
          typeofAlarm : '알람 곱게 받아라잉'
        }
        this.stompClient.send("/receiveAlarm", JSON.stringify(alram), {})
    },


    connect() {
      const serverURL = "http://localhost:9000/"
      let socket = new SockJS(serverURL)
      let message = "message"
      this.stompClient = Stomp.over(socket)
      // SockJs와 stomp.js를 사용하여 SockJS 서버가 연결을 기다리는 곳에 연결한다.
      this.stompClient.connect(
          {message},
          frame => {
            this.connected = true
            console.log(frame)
            this.stompClient.subscribe("/send", res => {
              this.recvList.push(JSON.parse(res.body))
            })

          },
          error => {
            console.log(error)
            this.connected = false
          }
      )
      let alarm = "alarm"
      this.stompClient.connect(
          {alarm},
          frame => {
            this.connected = true
            console.log(frame)
            this.stompClient.subscribe("/alarm", alarmRes => {
              console.log("알람 내용 =>>>>", JSON.parse(alarmRes.body))
              this.typeofAlarm = JSON.parse(alarmRes.body)
            })
          },
          error => {
            console.log('alarm error => ', error)
            this.connected = false
          }
      )
    },
    disConnect(){
      if(this.stompClient != null){
        this.stompClient.disconnect()
      }
      console.log('disConnected')
    },
  }
}
</script>

<style>
</style>
