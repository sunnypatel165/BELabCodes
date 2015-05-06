.model small
.data
x db 59h
y db 34h
sum db ?
car db ?
.code
start:
mov ax,@data
mov ds,ax

mov al,x
mov bl,y
add al,bl
daa
mov sum,al

mov al,00h
adc al,00
mov car,al

mov ah,4ch
int 21h
end start