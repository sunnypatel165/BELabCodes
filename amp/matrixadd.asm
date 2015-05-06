.model small
.data
str1 db 10,13,"Enter the first matrix: $"
str2 db 10,13,"Enter the second matrix: $"
str3 db 10,13,"The result is: $"
str4 db 10,13,"$"
str5 db 10,13,"enter the value of r: $"
str6 db 10,13,"enter the value of c: $"
m1 db 9 dup(?)
m2 db 9 dup(?)
m3 dB 100 dup(?)
r db ?
y db ?
c db ?
el db ?
prod db ?

.code
start:
mov ax,@data
mov ds,ax
mov es,ax
lea si,m1
lea di,m2

lea dx,str5
mov ah,09h
int 21h
mov ah,01h
int 21h
sub al ,30h
cmp al,0ah
jc lessThanAn
	sub al,07h
lessThanAn:
	mov r,al

lea dx,str6
mov ah,09h
int 21h
mov ah,01h
int 21h
sub al ,30h
cmp al,0ah
jc lessThanAc
	sub al,07h
lessThanAc:
	mov c,al
mul r
mov prod,al


lea dx,str1
mov ah,09h
int 21h
lea dx,str4
mov ah,09h
int 21h

mov bx,0000h
mov bl,r
main:
	mov cx,0000h
	mov cl,c
	agn:
		mov dl,20h
		mov ah,01h
		int 21h
		sub al ,30h
		cmp al,0ah
		jc lessThanA
			sub al,07h
		lessThanA:
			mov [si],al
			inc si
		mov ah,02h
		int 21h 
		loop agn
	lea dx,str4
	mov ah,09h
	int 21h

	dec bx
	cmp bx,00h
	jnz main

lea dx,str2
mov ah,09h
int 21h
lea dx,str4
mov ah,09h
int 21h

mov bx,0000h
mov bl,r
main2:
	mov cx,0000h
	mov cl,c
	agn2:
		mov dl,20h
		mov ah,01h
		int 21h
		sub al ,30h
		cmp al,0ah
		jc lessThanA2
			sub al,07h
		lessThanA2:
			mov [di],al
			inc di
		mov ah,02h
		int 21h 
		loop agn2
	lea dx,str4
	mov ah,09h
	int 21h

	dec bx
	cmp bx,00h
	jnz main2



lea dx,str3
mov ah,09h
int 21h

lea dx,str4
mov ah,09h
int 21h

mov cl,prod
mov y,0000h
lea si,m1
lea di,m2
addm:
	mov ah,30h
	mov al,[si]
	mov dl,[di]
	add al,dl
	add al,30h
	cmp al,3Ah
	jc OVER
		add al,07h

	OVER:
	cmp al,47h
	jc OVER1
	mov ah,31h
	sub al,17h
	cmp al,3Ah
	jc OVER1
	add al,07h

OVER1:
	mov bx,ax
	MOV DL,bh
	MOV AH,02H
	INT 21H
	
	mov dl,bl
	mov ah,02h
	INT 21H

	mov dl,20h
	int 21h
	

	inc si
	inc di
	inc y

	mov bl,c
	cmp bl,y
	jnz sameLine
		mov y,0000h
		lea dx,str4
		mov ah,09h
		int 21h
sameLine:
	loop addm



mov ah,4ch
int 21h
end start
	