let massR=parseFloat(prompt("Enter R Mass"));
let HeightR=parseFloat(prompt("Enter R Height"));
let massA=parseFloat(prompt("Enter A Mass"));
let HeightA=parseFloat(prompt("Enter A Height"));

let BMIR;
let BMIA;

BMIR=massR/(HeightR*HeightR);
BMIA=massA/(HeightA*HeightA);

console.log("BMI of Ratan:"+BMIR);
console.log("BMI of Anu:"+BMIA);

document.writeln("BMI of Ratan: "+BMIR +"<br>");
document.writeln("BMI of Anu: "+BMIA+"<br>");


let RatanHigherBMI=BMIR>BMIA;

console.log("Ratan sir has higher BMI than Anu= "+ RatanHigherBMI);

document.write("Ratan sir has higher BMI than Anu= "+ RatanHigherBMI);