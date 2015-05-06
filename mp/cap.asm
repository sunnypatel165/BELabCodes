.model small
.data
str1 db "enter a lower case string(length 5): $"
str2 db 10,13,"the upper case string is: $"
str3 db 200 dup('$')
.code
start:
mov ax,@data
mov ds,ax

lea dx,str1
mov ah,09h
int 21h

mov byte ptr str3,21
lea dx,str3
mov ah,0ah
int 21h


lea bx,str3+2
mov cx,0005h
agn:
mov al,[bx]
sub al,20h
mov [bx],al
inc bx
loop agn

lea dx,str2
mov ah,09h
int 21h

lea dx,str3+2
mov ah,09h
int 21h


mov ah,4ch
int 21h
end start
