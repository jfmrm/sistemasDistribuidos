import amqp from 'amqplib';

export function startReceiving() {
    return amqp.connect('amqp://localhost')
        .then((conn) => {
            return conn.createChannel()
        }).then((ch) => {
            let q = 'hello';
    
            ch.assertQueue(q, { durable: false });
            console.log('Waiting for messages');
            ch.consume(q, (msg) => {
                console.log(" [x] Received %s", msg.content.toString());
            }, {noAck: true});
        });
}