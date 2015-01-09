public double fastPower(double x, int n){
  if(n==0){
     return 1;
  }
  else if(n%2==0){
    return fastPower(x*x, n/2);
  }
  else{
    return x*fastPower(x*x, (n-1)/2);
  }
}
