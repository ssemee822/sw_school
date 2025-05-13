const arr1 = [1,2,3];
const arr2 = [4,5,6];
const arr3 = arr1.concat(arr2);
console.log("arr3: ", arr3);

const arr4 = [...arr1, ...arr2];
console.log("arr4: ", arr4);

const obj1 = {name: "ksm", age: "12"};
const obj2 = {addr: "test", position: "center"};
const obj3 = {...obj1, ...obj2, name:"kbs"};
console.log("obj3: ", obj3);

const sum = (...numbers) => {
  return numbers.reduce((a, b) => a + b, 0);
};

console.log(sum(1,4,5,6,7,7,655));