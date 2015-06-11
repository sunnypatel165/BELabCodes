.model small
.data
arr db 10,9,8,7,6,5,4,3,2,1
count dw 10
.code
start:
mov ax,@data
mov ds,ax

mov dx,count
dec dx

back:
mov cx,dx
lea si,arr
agn:
mov al,[si]
inc si
cmp al,[si]
jc over
xchg al,[si]
mov [si-1],al

over:
loop agn
dec dx
jnz back

mov ah,4ch
int 21h
end start