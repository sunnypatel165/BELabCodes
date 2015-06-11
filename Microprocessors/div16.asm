.model small
.data
x dd 12000001h
y dw 2000h
quo dw ?
rem dw ?
.code
start:
mov ax,@data
mov ds,ax
lea bx,x
mov ax,[bx]
mov dx,[bx+2]
div y
mov quo,ax
mov rem,dx
mov ah,4ch
int 21h
end start