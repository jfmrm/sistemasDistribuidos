import amqp from 'amqplib';

export function startSending() {
    return amqp.connect('amqp://localhost')
        .then((conn) => {
            return conn.createChannel()
        }).then((channel) => {
                let q = 'hello';
                channel.assertQueue(q, { durable: false });
                channel.sendToQueue(q, Buffer.from("Hello World!"));
                console.log("[x] Sent Hello World!");
        });
}
