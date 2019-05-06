# Questão 1
A diferença entre o primeiro e o segundo é a adição a simulação de tempo feita para resolver cada tarefa da fila, e a divisão entre vários consumers, introduzindo o conceito de Roud Robin.
No terceiro tutorial entra a abstração do Exchange, que possibilita a criação de grupos de canais, dando mais poder para o manuseio das tarefas entre canais.

# Questão 2
Ao ativar a opção durable o Rabbit vai escrever em disco cada uma das mensagens, garantindo a persistência, apesar de haver um breve espaço de tempo entre a entrada da mensagem na fila e a escrita no disco, nesse momento podem haver perdas.

# Questão 3
Poderia-se usar de um canal com ack ativo, de modo que apenas quando o ack for enviado a mensagem será removida da fila.