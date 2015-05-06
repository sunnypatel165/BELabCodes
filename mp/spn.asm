.model small
.data 
arr db 1,-1,2,-2,3,-3,4,-4,5,-5
parr db 10 dup(?)
narr db 10 dup(?)
count dw 10
.code
start:
mov ax,@data
mov ds,ax
mov es,ax
lea si,arr
lea di,parr
lea bx,narr
mov cx,count

agn:
mov al,[si]
cmp al,00h
JS nega

mov [di],al
inc di
jmp over

nega:
mov [bx],al
inc bx

over:
inc si
loop agn

mov ah,4ch
int 21h
end start