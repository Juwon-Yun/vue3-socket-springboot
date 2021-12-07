<template>
  <div class="container">
    <nav style="height: 70px">
    </nav>
  </div>
  <ProjectDetail/>
</template>

<script>
import ProjectDetail from "@/components/ProjectDetail";

export default {
  name: 'App',
  components: {
    ProjectDetail,
  },
  data() {
    return {
      userName : "",
      message: "",
      recvList: [],
    }
  },
  created() {
    // this.connect()
  },
  methods: {
    // alarm() {
    //   if(this.stompClient && this.stompClient.connected) {
    //     const msg = {
    //       alarm: 'get alarm'
    //     }
    //     this.stompClient.send("/alarm", JSON.stringify(msg), {})
    //   }
    // },

    // sendMessage(e) {
    //   if(e.keyCode === 13 && this.userName.trim() !== '' && this.message.trim() !== '') {
    //     this.send()
    //     this.message = ''
    //   }
    // },
    // send() {
    //   if(this.stompClient && this.stompClient.connected) {
    //     const msg = {
    //       userName: this.userName,
    //       content: this.message
    //     }
    //     this.stompClient.send("/receive", JSON.stringify(msg), {})
    //   }
    // },


    // connect() {
    //   const serverURL = "http://localhost:9000/"
    //   let socket = new SockJS(serverURL)
    //   this.stompClient = Stomp.over(socket)
    //   SockJs와 stomp.js를 사용하여 SockJS 서버가 연결을 기다리는 곳에 연결한다.
      // this.stompClient.connect(
      //     {},
      //     frame => {
      //       this.connected = true
      //       console.log(frame)
      //       this.stompClient.subscribe("/send", res => {
      //         console.log("소켓에서 수신한 내용 =>>>>", JSON.parse(res.body))
              // this.recvList.push(JSON.parse(res.body))
            // })
          // },
          // error => {
          //   console.log(error)
          //   this.connected = false
          // }
      // )

    // },
    // disConnect(){
    //   if(this.stompClient != null){
    //     let chatBox = document.querySelector('#chatBox')
    //     console.log(chatBox)
    //     chatBox.innerHTML = ''
    //     this.stompClient.disconnect()
    //   }
    //   console.log('disConnected')
    // },
  }
}
</script>

<style scoped>

.container {
  width: 100%;
  display: flex;
  flex-direction: column;
  background: #16161A;
}

nav {
  widows: 100%;
  height: 70px;
  background: #75757529;
  color: #ffffff;
}
</style>
