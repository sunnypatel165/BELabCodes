.model small

.data
arr db 1,2,3,4,5,6,7,8,9,10
search db 7
index dw ?
count dw 10

.code
start:
mov ax,@data
mov ds,ax
mov es,ax
lea di,arr

mov al,search
mov cx,count
cld

repne scasb

mov ax,count
sub ax,cx
mov index,ax

mov ah,4ch
int 21h
end start