import http from 'k6/http';
import { sleep } from 'k6';

export let options = {
  stages: [
    { duration: '30s', target: 500 },
    { duration: '2m', target: 5000 },
    { duration: '10s', target: 500 },
  ],
};

export default function () {
  let res = http.get('http://127.0.0.1:35261/swagger-ui/index.html');
  sleep(1);
}
