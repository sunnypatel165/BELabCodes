.model small
.data
arr db 1,2,3,4,5,6,7,8,9,10
oc db ?
ec db ?
count dw 10
.code
start:
mov ax,@data
mov ds,ax
lea si,arr
mov cx,count

agn:
mov al,[si]
ror al,1
JC odd
inc ec
jmp over

odd:
inc oc

over:
inc si
loop agn

mov ah,4ch
int 21h
end start