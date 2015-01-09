	load x
	add y
	stor w
	sub w
	jzero zerostuff
	load y
zerostuff: load z
	stor q
	load x
	jpos posstuff
	load y
posstuff: stor r
	jump jumpstuff
	load y
jumpstuff: load y
	stor s
	halt
x:5
y:1
z:4
w:0
q:0
r:0
s:0


