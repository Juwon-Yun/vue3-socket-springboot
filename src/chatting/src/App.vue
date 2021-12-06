<template>
  <div id="app">
    알람 팝업하기 => <input @click="alarm" type="button" value="RequestAlarm">
    유저이름 : <input v-model="userName" type="text">
    내용 : <input v-model="message" type="text" @keyup="sendMessage">
    <hr>
    <div v-for="(item, idx) in recvList" :key="idx" id="chatBox">
      <h3 >{{item.userName}} :: {{item.content}}</h3>
    </div>
    <hr>
    <input type="button" value="disconnect" @click="disConnect">
    <input type="button" value="connect" @click="connect">
    <div >
      <h3> {{this.typeofAlarm}} </h3>
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
    alarm() {
      if(this.stompClient && this.stompClient.connected) {
        const msg = {
          alarm: 'get alarm'
        }
        this.stompClient.send("/alarm", JSON.stringify(msg), {})
      }
    },

    sendMessage(e) {
      if(e.keyCode === 13 && this.userName.trim() !== '' && this.message.trim() !== '') {
        this.send()
        this.message = ''
      }
    },
    send() {
      if(this.stompClient && this.stompClient.connected) {
        const msg = {
          userName: this.userName,
          content: this.message
        }
        this.stompClient.send("/receive", JSON.stringify(msg), {})
      }
    },


    connect() {
      const serverURL = "http://localhost:9000/"
      let socket = new SockJS(serverURL)
      this.stompClient = Stomp.over(socket)
      // SockJs와 stomp.js를 사용하여 SockJS 서버가 연결을 기다리는 곳에 연결한다.
      this.stompClient.connect(
          {},
          frame => {
            this.connected = true
            console.log(frame)
            this.stompClient.subscribe("/send", alarmRes => {
              console.log("알람 내용 =>>>>", JSON.parse(alarmRes.body))
              this.typeofAlarm = JSON.parse(alarmRes.body)
            })
          },
          error => {
            console.log(error)
            this.connected = false
          }
      )

    },
    disConnect(){
      if(this.stompClient != null){
        let chatBox = document.querySelector('#chatBox')
        console.log(chatBox)
        chatBox.innerHTML = ''
        this.stompClient.disconnect()
      }
      console.log('disConnected')
    },
  }
}
</script>

<style>
</style>
