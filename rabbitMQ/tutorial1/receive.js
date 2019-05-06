import amqp from 'amqplib';

export function startReceiving(name) {
    return amqp.connect('amqp://localhost')
        .then((connection) => {
            return connection.createChannel();
        }).then((channel) => {
            const queue = 'task_queue';
            
            channel.assertExchange('logs1', 'fanout', {
                durable: false
            });

            channel.assertQueue('', { exclusive: true })
                .then((q) => {
                    console.log(" [*] Waiting for messages in %s. To exit press CTRL+C", q.queue);
                    channel.bindQueue(q.queue, 'logs1', '');

                    channel.prefetch(1);
                    console.log(" [*] Waiting for messages in %s. To exit press CTRL+C", queue);

                    channel.consume(q.queue, (msg) => {
                        console.log(" [x] Received %s", msg.content.toString());
                    }, {noAck: true});
                })
        });
}

startReceiving("yow")