
const alarmAndChat = {
    namespaced : true,
    state(){
        return{
            alarmColor : '',
            chat : {
                userName : '초기값',
                message : '초기값',
            },
            cnt: 0
        }
    },
    mutations : {
        setAlarmColor(state, color){
            state.alarmColor = color
        },
        setChatting(state, arr){
            console.log('arr =>>',arr)
            state.chat.userName = arr.userName
            state.chat.message = arr.content
            console.log(state.chat)
        }
    },
    actions : {

    },

}

export default alarmAndChat;