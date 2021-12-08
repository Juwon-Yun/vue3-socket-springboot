
const alarmAndChat = {
    namespaced : true,
    state(){
        return{
            alarmColor : '',
            sendChat : {
                id : 'default',
                text : 'default',
                date : 'default',
                // 이미지는 projectList(projects)에서 따로 받아와야한다 
                img : '',
            },
            receivedChat : {
                id : 'received',
                text : 'received',
                date : 'received',
                img : '',
            },
            alarmCnt: 0,
            chatCnt : 0,
            receiveChatCnt : 0,
        }
    },
    mutations : {
        setAlarmColor(state, color){
            state.alarmColor = color
        },
        setSendChatting(state, arr){
            // console.log('arr =>>',arr)
            state.sendChat.id = arr.id
            state.sendChat.text = arr.text
            state.sendChat.date = arr.date
            // console.log('state => ',state.chat)
        },
        serReceivedChatting(state,arr){
            console.log('arr => ',arr)
            state.receivedChat.id = arr.id
            state.receivedChat.text = arr.text
            state.receivedChat.date = arr.date
            console.log('state => ', state.receivedChat)
        },
        increaseAlarmCnt(state){
            state.alarmCnt++
        },
        increaseChatCnt(state){
            state.chatCnt++
        },
        increasereceiveChatCnt(state){
            state.receiveChatCnt++
        },
    },
    actions : {

    },

}

export default alarmAndChat;