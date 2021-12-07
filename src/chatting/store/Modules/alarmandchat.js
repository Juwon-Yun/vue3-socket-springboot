
const alarmAndChat = {
    namespaced : true,
    state(){
        return{
            alarmColor : '',
            userName : "",
            message: "",
        }
    },
    mutations : {
        setAlarmColor(state, color){
            // console.log('color => ', color)
            state.alarmColor = color
        },

        getAlarmColor(state){
            console.log('get알ㄹ람', state.alarmColor)
            return state.alarmColor
        },

    },
    actions : {


    },
    
}

export default alarmAndChat;