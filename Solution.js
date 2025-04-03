/*
Implement a JavaScript ES6 module named AdvancedFactorialTool that calculates 
factorials of numbers provided by the user. The implementation should 
integrate the following ES6 features:

1. Implement your own ES6 class named CustomMap to mimic JavaScript's built-in Map.
2. Use the above-created CustomMap explicitly for caching factorial results to 
   avoid redundant calculations.
3. Provide a deepClone function to clone the cache object deeply, protecting the 
   internal state from accidental external modifications.
4. Implement a generator named factorialGenerator(n) which yields factorial 
   results sequentially from 1! to n!.

*/


class CustomMap {
    // write your code here
    constructor(){
        this.store=new Map()
    }
        set(key,value){
            this.store[key] = value;
        }
        get(key){
            return this.store[key];                                                                                                                                          
        }
        has(key){
            return this.store.has(key);
        }
        deepClone(){
            return new Map(this.store);
        }
    }
    
  
  
  
  const AdvancedFactorialTool = {
      cache: new CustomMap(),
    factorialMemoized(n) {
      // write your code here
      if(n===0 || n===1) return 1;
      if(this.cache.has(n)){
          return this.cache.get(n);
      }
      let result=n*this.factorialMemoized(n-1);
      this.cache.set(n,result);
      return result;
    },
  
    deepClone(obj) {
      if (obj===null || typeof(obj)!== "object") return obj ;
        
      // write your code here
      if (Array.isArray(obj)) return obj.map(this.deepClone);
      
      var newobj = obj;
      for (const k in obj)
        newobj[k] = this.deepClone(obj[k]);
      
      return newobj;
    },
  
    *factorialGenerator(n) {
      // write your code here
      let fact=1;
      for(let i=1;i<=n;i++){
          fact*=i;
          yield fact;
      }
    }
  };
  
  //Testing code
  function testFactorialTool(n) {
    console.log(`Factorial of ${n} (Memoized):`, AdvancedFactorialTool.factorialMemoized(n));
  
    const originalCache = AdvancedFactorialTool.cache;
    const clonedCache = AdvancedFactorialTool.deepClone(originalCache);
  //   clonedCache.set(n, "modified");
    console.log("Original cache after clone modification:", originalCache.get(n));
  
    console.log(`Factorial sequence up to ${n}:`, [...AdvancedFactorialTool.factorialGenerator(n)]);
  }
  
  const readline = require('readline').createInterface({
    input: process.stdin,
    output: process.stdout
  });
  
  readline.question('Enter a positive integer to calculate factorial: ', input => {
    const n = parseInt(input.trim());
  
    if (isNaN(n) || n <= 0) {
      console.log('Please enter a valid positive integer.');
    } else {
      testFactorialTool(n);
    }
  
    readline.close();
  });
  