DATA
	x	10000*0xffff
PROGRAM
	jump next
next	brov 0x400
	brzr next1
next1	brng 0x400
	imlo r3 0x25
	imhi r3 3
	imlo r4 15
	load r2 [r4]
	stor [r3] r3
	and r2 r3 r4
	or r2 r3 r4
	nxor r2 r3 r4
	rem r2 r3 r4
	add r2 r3 r4
	sub r2 r3 r4
	mult r2 r3 r4
	div r2 r3 r4
	read r2
	write r2
	halt
END