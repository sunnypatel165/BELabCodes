.model small
.data
x dw 0ffffh
y dw 0ffffh
sum dw ?
carry db ?
.code
start:
mov ax,@data
mov ds,ax
mov ax,x
mov bx,y
add ax,bx
mov sum,ax
mov ax,0000
adc al,00
mov carry, al
mov ah,4ch
int 21h
end start