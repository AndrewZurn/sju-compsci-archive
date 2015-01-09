data
       #empty data section
program
        read r2       # read in a number to r2
        imlo r3 0     # set r3 to zero
test    sub  r4 r2 r3 # while r3 < r2 and r2>0	
        brzr endprog
        brng endprog
        add r3 r3 r1  # add one to r3
        write r3      #print r3
        jump test     #goto while statment
endprog halt
end
