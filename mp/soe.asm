.model small
.data
arr db 1,2,3,4,5,6,7,8,9,10
oarr db 10 dup(?)
earr db 10 dup(?)
count dw 10
.code
start:
mov ax,@data
mov ds,ax
mov es,ax
lea si,arr
lea di,oarr
lea bx,earr
mov cx,count

agn:
mov al,[si]
ror al,1
JC odd
rol al,1
mov [bx],al
inc bx
jmp over

odd:
rol al,1
mov [di],al
inc di
jmp over

over:
inc si
loop agn

mov ah,4ch
int 21h
end start