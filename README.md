# javaproblem
#store Queen at index such each queen should not croos eachother 


approach...

1..check kisi index pe queen ko store krns safe hai ki nhi
     1 up vertex
row++ col same rhega


2 left up daigonal
   for loop  i=row-1,j=col-1;i>=0 && j>=0

3 right up daigonal
    for loop  i=row-1,j=col+1;i>=0 && j<arr.length
