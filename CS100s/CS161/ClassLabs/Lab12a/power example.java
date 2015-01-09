public double power(double x, int n){
  if(n==1){
    return x;
  }
  else{
    return x*power(x, n-1);
  }
}
