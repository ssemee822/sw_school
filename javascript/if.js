const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim();

let productList = [
  { name: "레쓰비", price: 700 },
  { name: "티오피", price: 1000 },
  { name: "비타500", price: 800 },
  { name: "포카리스웨트", price: 1000 },
  { name: "파워에이드", price: 1200 }
];

let res = productList.filter(ele => ele.price <= input);
let resName = res.map(ele => ele.name);
console.log(resName);