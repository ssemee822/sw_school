// // for (let i=1; i <= 9; i++){
// //   console.log(`${i} * ${i} = ${i*i}`);
// // }
// const num = Number(prompt("input number : "));

// if (num > 0) {
//   console.log(`${num} is positive`);
//   document.write(`<h1>${num} is positive</hi>`);
// }
// else {
//   console.log(`${num} is not positive`);
//   document.write(`<h1>${num} is not positive</hi>`);
// }
// const PI = 3.14;
// console.log(PI * 20);

const name = prompt("put the name here : ");
const greeting = document.getElementById("greeting");
console.log("Hello, " + name);
if (name) {
  greeting.innerText = "Hello, " + name;
} else {
  greeting.innerText ="There is no name";
}