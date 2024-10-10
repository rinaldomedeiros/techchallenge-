import http from 'k6/http';
import { sleep } from 'k6';

export let options = {
  stages: [
    { duration: '30s', target: 100 },
    { duration: '3m', target: 700 },
    { duration: '5ms', target: 1000 },
  ],
  vusMax: 1000,
};

export default function () {
  let res = http.get('http://127.0.0.1:33803/swagger-ui/index.html');
  sleep(1);
}
