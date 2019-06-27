helper = [A.length]
for(i 0...A.length-1){
    helper[A[i]-1]=1;
}
for(i 0...A.length-1){
    if(helper[i]==0)
        return i+1;
}
return A.length+1;