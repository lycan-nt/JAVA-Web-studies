const amqp = require('amqplib');
const queue = 'PRECO';

amqp.connect({
    host: 'localhost',
    port: '5672',
    username: 'admin',
    password: 'admin'
}).then((conexao) => {
    conexao.createChannel()
        .then((canal) => {
            canal.consume(queue, (mensagem) => {
                console.log(mensagem.content.toString());
            }, {noAck: true})
        }).catch((error) => console.log(error));

}).catch((error) => {
    console.log(error);
})