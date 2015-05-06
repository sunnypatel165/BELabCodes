.model small
.586
.data
arr dw 0,9,10 dup(0)
str1 db 10,13,"done:$"
.code
start:
mov ax,@data
mov ds,ax
lea si,arr
mov di,15

bound di,[si]
lea dx,str1
mov ah,09h
int 21h

mov ah,4ch
int 21h
end start