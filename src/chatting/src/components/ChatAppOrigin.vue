<template>
  <div id="app">
    파랑 팝업하기 => <input @click="alarm('#6464CD')" type="button" value="blue">
    빨강 팝업하기 => <input @click="alarm('#FFB900')" type="button" value="orange">
    초록 팝업하기 => <input @click="alarm('#9EF048')" type="button" value="green">
    유저이름 : <input v-model="userName" type="text">
    내용 : <input v-model="message" type="text" @keyup="sendMessage">
    <hr>
    <div v-for="(item, idx) in recvList" :key="idx" id="chatBox">
      <h3 v-if="item.userName !==null && item.content !== null">
        {{item.userName}} : {{item.content}}
      </h3>
    </div>
      <h3 v-if="this.alarmState !== null && this.alarmState !== ''">
        {{this.alarmState}}
      </h3>
    <hr>
    <input type="button" value="disconnect" @click="disConnect">
    <input type="button" value="connect" @click="connect">
  </div>
</template>

<script>
//stompClient는 내장된 변수
import Stomp from 'webstomp-client'
import SockJS from 'sockjs-client'
import {mapMutations} from 'vuex'

export default {
  name: 'ChatAppOrigin',
  components: {
  },
  data() {
    return {
      userName : "",
      message: "",
      recvList: [],
      alarmState : '',
    }
  },
  created() {
    this.connect()
  },
  methods: {
    ...mapMutations({
       setAlarmColor : 'alarmAndChat/setAlarmColor',
    }),


    alarm(color) {
      if(color !== null){
        if(this.stompClient && this.stompClient.connected) {
          const msg = {
            alarm: color
          }
          this.stompClient.send("/alarm", JSON.stringify(msg), {})
        } // stomp if
      } // color if
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
              let arr = JSON.parse(res.body)
              if(arr.alarm !== null && arr.alarm !== ''){
                this.alarmState = arr.alarm
                this.setAlarmColor(arr.alarm)
              }else{
                this.recvList.push(JSON.parse(res.body))
              }
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
        // chatBox.innerHTML = ''
        this.stompClient.disconnect()
      }
      console.log('disConnected')
    },
  },// methods
  watch : {
    alarmState(){
      console.log('socket.vue에서의 watch', this.alarmState)
    }
  },
}
</script>

<style scoped>

</style>