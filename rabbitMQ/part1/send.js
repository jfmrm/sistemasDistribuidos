import amqp from 'amqplib';

export function startSending() {
    return amqp.connect('amqp://localhost')
        .then((connection) => {
            return connection.createChannel()
        }).then((channel) => {
            const queue = 'task_queue';
            for(let i = 0; i < 10; i ++) {
                let msg = `${i} function .....`;
    
                channel.assertQueue(queue, {
                    durable: true
                });
                channel.sendToQueue(queue, Buffer.from(msg), {
                    persistent: true
                });
                console.log(" [x] Sent '%s'", msg);
            }
        });
}

startSending()