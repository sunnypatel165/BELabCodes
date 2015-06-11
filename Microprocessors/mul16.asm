.model small
.data
x dw 1234h
y dw 2345h
mult1 dw ?
mult2 dw ?
.code
start:
mov ax,@data
mov ds,ax
mov ax,x
mul y
mov mult1,ax
mov mult2,dx
mov ah,4ch
int 21h
end start