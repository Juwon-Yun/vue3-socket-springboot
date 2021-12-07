<template>
  <div id="app">
    알람 팝업하기 => <input @click="alarm" type="button" value="RequestAlarm">
    유저이름 : <input v-model="userName" type="text">
    내용 : <input v-model="message" type="text" @keyup="sendMessage">
    <hr>
    <div v-for="(item, idx) in recvList" :key="idx" id="chatBox">
      <h3 v-if="item.userName !==null && item.content !== null">
        {{item.userName}} : {{item.content}}
      </h3>
      <h3 v-if="item.alarm !== null">
        {{item.alarm}}
      </h3>
    </div>
    <hr>
    <input type="button" value="disconnect" @click="disConnect">
    <input type="button" value="connect" @click="connect">
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
            this.stompClient.subscribe("/send", res => {
              console.log("소켓에서 수신한 내용 =>>>>", JSON.parse(res.body))
              // for (let resKey of res) {
              //   if(resKey.alarm != null){
              //     this.recvList.push(JSON.parse(res.body))
              //   }
              // }
              this.recvList.push(JSON.parse(res.body))
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
