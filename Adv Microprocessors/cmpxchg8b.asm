.model small
.586
.data
v dq 1234567890ABCDEFh
.code
start:
mov ax,@data
mov ds,ax
mov es,ax

mov edx,12345678h
mov eax,90ABCDEFh
mov ecx,11111111h
mov ebx,11111111h
lea di,v

cmpxchg8b [di]

mov ah,4ch
int 21h
end start