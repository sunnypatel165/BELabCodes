.model small
.data
x dw 1000h
y dw 0ffffh
sum dw ?
carry db ?
.code
start:
mov ax,@data
mov ds,ax
mov ax,x
mov bx,y
sub ax,bx
mov sum,ax
mov ax,0000
sbb al,00
mov carry, al
mov ah,4ch
int 21h
end start