import amqp from 'amqplib';

export function startReceiving(name) {
    return amqp.connect('amqp://localhost')
        .then((connection) => {
            return connection.createChannel();
        }).then((channel) => {
            const queue = 'task_queue';
            
            channel.assertQueue(queue, {
                durable: true
            });
            channel.prefetch(1);
            console.log(" [*] Waiting for messages in %s. To exit press CTRL+C", queue);
            channel.consume(queue, (msg) => {
                let secs = msg.content.toString().split('.').length - 1;
        
                console.log(" [x] Received %s", msg.content.toString());
                setTimeout(() => {
                    console.log(" [x] Done");
                    channel.ack(msg);
                }, secs * 1000);
            }, {noAck: false});
        });
}

startReceiving("yow")