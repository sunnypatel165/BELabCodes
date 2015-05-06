.model small
.data
arr db 0,1,2,3,4,0,-1,-2,-3,-4
posi db ?
negt db ?
zer db ?
count dw 10
.code
start:
mov ax,@data
mov ds,ax
lea si,arr
mov cx,count

agn:
mov al,[si]
cmp al,00h
JZ zeros
JS nega

inc posi
jmp over

nega:
inc negt
jmp over


zeros:
inc zer

over:
inc si
loop agn

mov ah,4ch
int 21h
end start

