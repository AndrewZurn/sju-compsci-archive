DATA
	#This shows an example of all "real" instructions
PROGRAM
	halt
	jump jumpspot
	brov jumpspot
	brzr jumpspot
	brng jumpspot
jumpspot imlo r2 -3
	imhi r2 0x4
	load r8 [r4]
	stor [r2] r4
	and r2 r4 r8
	or r8 r2 r4
	nxor r4 r8 r2
	rem r2 r3 r4
	add r2 r3 r4
	sub r2 r3 r4
	mult r2 r3 r4
	div r2 r3 r4
	halt
END
