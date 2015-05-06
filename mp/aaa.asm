.model small
.data
x dw 3235h
y db 39h
sum dw ?
.code
start:
mov ax,@data
mov ds,ax
mov ax,x
sub ax,3030h
mov bl,y
sub bl,30h
add al,bl
aaa
add ax,3030h
mov sum,ax
mov ah,4ch
int 21h
end start