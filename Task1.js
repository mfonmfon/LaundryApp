let testScores = [43,56,67,87,98,77,69,84,91,76]
function update(testScores){
     return testScores > 70
}
let result = testScores.filter(update);

console.log(result);

let studentScores = [85,92,78,88,95];

newScores = studentScores.map((num) => num + 5);

console.log(newScores);

listOfNumbers = [2,4,6,8,10]

squaredNummbers = listOfNumbers.map((square) => square * square);

console.log(squaredNummbers);

listOfMembers = ["Emily", "Jack", "Sophie", "Daniel"]

listOfBooks = ["Rich Dad Poor Dad", "Psychology Of Money", "Richest Man In Babylon", "Think And Grow Rich"]

for (let iterate of listOfMembers ){
     let allocate = listOfBooks.shift();
     console.log(`${iterate} ${allocate}`);
}

let time = ["9:00 AM", "11:00 AM", "1:00 PM", "3:00 PM", "5:00 PM"];





























