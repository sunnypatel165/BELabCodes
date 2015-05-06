.model small
.data
x db 86h
y db 57h
sum db ?
car db ?
.code
start:
mov ax,@data
mov ds,ax

mov al,x
mov bl,y
sub al,bl
das
mov sum,al

mov al,00h
sbb al,00
mov car,al

mov ah,4ch
int 21h
end start