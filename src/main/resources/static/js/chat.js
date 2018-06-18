var vm = new Vue({
    el: ".container",
    data: {
        username: '',
        stompClient: null
    },
    methods: {
        connect: function(){
            var self = this;

            var socket = new SockJS('/ws');
            self.stompClient = Stomp.over(socket);
            self.stompClient.connect({}, self.onConnected, self.onError);
        },
        onConnected: function(){
            var self = this;
            // 订阅
            self.stompClient.subscribe('/msg/datetime', self.onMessageReceived);

            // 发送
            self.stompClient.send("/api/chatting",
                {},
                JSON.stringify({username: self.username})
            )
        },
        onError: function(){
            alert("出错了。。。")
        },
        onMessageReceived: function(data){
            $('#msg').html(data.body);
//            var message = JSON.parse(data.body);
//            alert(message.username);
        }
    }
});