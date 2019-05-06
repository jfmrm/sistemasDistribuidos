import {startSending} from './send';
import {startReceiving} from './receive';

startReceiving("worker1")
startReceiving("worker2")
startReceiving("worker3")
startSending()
