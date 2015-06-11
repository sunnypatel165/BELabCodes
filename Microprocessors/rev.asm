.model small
.data
arr db 1,2,3,4,5,6,7,8,9,10
rev db 10 dup(?)
count dw 10

.code
start:

mov ax,@data

mov ds,ax
lea si,arr

mov es,ax
lea di,rev

mov cx,count
add di,cx
dec di

agn:
	cld
	lodsb
	std
	stosb
loop agn

mov ah,4ch
int 21h
end start

