.model small
.data
str1 db "enter a char: $"
str2 db 10,13,"the char is: $"
a db ?
.code
start:
mov ax,@data
mov ds,ax

lea dx,str1
mov ah,09h
int 21h

mov ah,01h
int 21h
mov a,al

lea dx,str2
mov ah,09h
int 21h

mov dl,a
mov ah,02h
int 21h

mov ah,4ch
int 21h
end start