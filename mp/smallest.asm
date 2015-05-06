.model small
.data
arr db 10,20,8,7,6,5,4,3,2,1
sma db ?
count dw 10
.code
start:
mov ax,@data
mov ds,ax
mov cx,count
dec cx

lea si,arr
mov bl,[si]
inc si

agn:
mov al,[si]
cmp bl,al
jnc smal
jmp over

smal:
mov bl,al
over:
inc si
loop agn

mov sma,bl

mov ah,4ch
int 21h
end start