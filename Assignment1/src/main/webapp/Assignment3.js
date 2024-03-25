// Test data
const dolphinsScores = [96, 108, 89];
const koalasScores = [88, 91, 110];


averageScoreDolphins=




// Determine the winner
if (averageScoreDolphins > averageScoreKoalas && averageScoreDolphins >= 100) 
{
  console.log("Dolphins win the trophy");
} 
else if (averageScoreKoalas > averageScoreDolphins && averageScoreKoalas >= 100) 
{
  console.log("Koalas win the trophy");
} 
else if (averageScoreDolphins === averageScoreKoalas && averageScoreDolphins >= 100) 
{
  console.log("Both win the trophy");
} 
else 
{
  console.log("No winner. Average score must be at least 100.");
}